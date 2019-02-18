<template>
  <section>
    <el-row align="center">
      <el-col align="center">
        <el-steps :active="active" finish-status="success" :space="100/pageDefs.length + '%'" :align-center="true">
          <template v-for="(pageDef,index) in pageDefs">
            <el-step :title="pageDef.title" :icon="pageDef.icon" :name="pageDef.name"></el-step>
          </template>
        </el-steps>
      </el-col>
    </el-row>
    <el-tabs v-model="pageName" type="border-card">
      <template v-for="pageDef,index in pageDefs">
        <el-tab-pane :label="pageDef.title" :name="pageDef.name" :disabled="true">
          <template v-if="pageDef.extends === 'CscFormPage'">
            <el-row :gutter="20" class="formPage">
              <el-form :ref="pageDef.name" :model="datas[index]" :rules="pageDef.formRules" label-width="120px" label-position="right">
                <template v-for="(col,idx) in pageDef.pageCols">
                  <template v-if="col.inputType==='refType'">
                    <el-col :span="24/pageDef.columnNum" :key="idx">
                      <slot :name="pageDef.name + '.' + col.modelName"></slot>
                    </el-col>
                  </template>
                  <template v-else>
                    <csc-form-column :col="col" :form="datas[index]" :disabled="disabled" :span="24/pageDef.columnNum" @change="fieldChange" :idx="idx"></csc-form-column>
                  </template>
                </template>
              </el-form>
            </el-row>
            <el-row>
              <slot :name="pageDef.name + '.selfDefine'"></slot>
            </el-row>
          </template>
          <template v-if="pageDef.extends === 'CscMasterFormPage'">
            <el-row :gutter="20" class="formPage">
              <el-form :ref="pageDef.name" :id="pageDef.name" :model="datas[index]" :rules="pageDef.formRules" label-width="120px" label-position="right">
                <template v-for="(col,idx) in pageDef.pageCols">
                  <template v-if="col.inputType==='refType'">
                    <el-col :span="24/pageDef.columnNum" :key="idx">
                      <slot :name="pageDef.name + '.' + col.modelName"></slot>
                    </el-col>
                  </template>
                  <template v-else>
                    <csc-form-column :col="col" :form="datas[index]" :disabled="disabled" :span="24/pageDef.columnNum" @change="fieldChange" :idx="idx"></csc-form-column>
                  </template>
                </template>
              </el-form>
            </el-row>
            <el-row>
              <slot :name="pageDef.name + '.selfDefine'"></slot>
            </el-row>
            <template v-if="pageDef.childTabDefs && pageDef.childTabDefs.length > 0">
              <el-row>
                <el-tabs v-model="activeNames[index]" type="border-card">
                  <template v-for="childTabDef in pageDef.childTabDefs">
                    <el-tab-pane :label="childTabDef.title" :name="childTabDef.childFieldName">
                      <csc-child-edit-table :pageDef="childTabDef" :entity="datas[index]" @childFieldChange="childFieldChange"></csc-child-edit-table>
                    </el-tab-pane>
                  </template>
                </el-tabs>
              </el-row>
            </template>
          </template>
          <template v-if="pageDef.extends === 'CscChildEditTable'">
            <csc-child-edit-table :pageDef="pageDef" :entity="datas[index]" @childFieldChange="childFieldChange"></csc-child-edit-table>
          </template>
        </el-tab-pane>
      </template>
    </el-tabs>
    <template v-for="(pageDef,index) in pageDefs">
    </template>
    <br/>
    <el-row align="middle" class="bottomBtn">
      <el-col align="center">
        <el-button size="medium" type="primary" @click="prev" :disabled="active == 0">上一步</el-button>
        <el-button size="medium" type="primary" @click="next" v-if="active != pageDefs.length - 1">下一步</el-button>
        <el-button size="medium" type="primary" @click="doSave" v-else>保  存</el-button>
        <el-button size="medium" type="primary" @click="doCancel">返  回</el-button>
      </el-col>
    </el-row>
  </section>
</template>
<script>
  import CscChildEditTable from "@/components/CscChildEditTable/CscChildEditTable"
  import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"
  export default {
    name: 'CscStepsFormPage',
    props:{
      pageDefs:{
        type:Array,
        required: true
      },
      datas:{
        type:Array,
        required: true
      },
      disabled:Boolean
    },

    data() {
      return {
        active:0,
        activeNames:[],
        pageName:null
      };
    },

    components:{CscChildEditTable, CscFormColumn},

    created(){
      if (!this.datas) {
        this.datas = []
      }
      this.pageName = this.pageDefs[0].name
      for (var i = 0; i < this.pageDefs.length; i++) {
        if (this.datas.length <= i) {
          this.datas.push({})
        } else if (this.datas[i] === undefined || this.datas[i] === null) {
          this.datas[i] = {}
        }
        if (this.pageDefs[i].extends === 'CscMasterFormPage' && this.pageDefs[i].childTabDefs) {
          this.activeNames[i] = this.pageDefs[i].childTabDefs[0].childFieldName
          for (var j = 0; j < this.pageDefs[i].childTabDefs.length; j++) {
            this.pageDefs[i].childTabDefs[j]['buttonVisible'] = !this.disabled
          }
        } else {
          this.activeNames[i] = null
        }
      }
    },

    methods: {
      prev() {
        if (this.active > 0) this.active--;
        this.pageName = this.pageDefs[this.active].name
      },
      next() {
        if (this.active < this.pageDefs.length) {
          var pageDef = this.pageDefs[this.active]
          if (pageDef.formRules !== undefined) {
            let formComp = null
            if (this.$refs[pageDef.name] instanceof Array) {
              formComp = this.$refs[pageDef.name][0]
            } else {
              formComp = this.$refs[pageDef.name]
            }
            formComp.validate((valid) => {
              if (valid) {
                this.active++;
                this.pageName = this.pageDefs[this.active].name
              } else {
                return false;
              }
            });
          } else {
            this.active++;
            this.pageName = this.pageDefs[this.active].name
          }
        }
      },

      doSave() {
        if (this.active < this.pageDefs.length) {
          var pageDef = this.pageDefs[this.active]
          if (pageDef.formRules !== undefined) {
            let formComp = null
            if (this.$refs[pageDef.name] instanceof Array) {
              formComp = this.$refs[pageDef.name][0]
            } else {
              formComp = this.$refs[pageDef.name]
            }
            formComp.validate((valid) => {
              if (valid) {
                this.$emit('doSave', this.datas)
              } else {
                return false;
              }
            });
          } else {
            this.$emit('doSave', this.datas)
          }
        }
      },
      doCancel(){
        this.$emit('doCancel')
      },

      fieldChange(modelName, val){
        this.$emit('fieldChange', modelName, val, this.pageDefs[this.active]['name'])
      },

      childFieldChange(modelName, val, childName, form) {
        this.$emit('childFieldChange', modelName, val, childName, form, this.pageDefs[this.active]['name'])
      }
    }
  }
</script>