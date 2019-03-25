<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.name" placeholder="姓名111"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="getUser">查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <template>
      <el-table :data="users" highlight-current-row v-loading="loading" style="width: 100%;">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120" sortable>
          <template slot-scope="scope">
            <!--<u>1234</u>-->
            <!--<u>{{scope.row["name"]}}</u>-->
            <!--<router-link class="isLink" :to="{path:tabCol.url,query:{[tabCol.modelName]:scope.row[tabCol.prop]}}">-->
            <!--<u>{{scope.row[tabCol.prop]}}</u>-->
            <!--</router-link>-->
            <!--<router-link :to="{path:'/user/ManyTable',query:queryParam1}" @click.native="getUrlParam(scope.row,scope.$index)"><u>{{scope.row["name"]}}</u></router-link>-->

            <router-link :to="{path:'/user/ManyTable',query:queryParam1}" @click.native="getUrlParam(scope.row,scope.$index)"><u>{{scope.row["name"]}}</u></router-link>

          </template>
        </el-table-column>
        <el-table-column prop="sex" label="性别" width="100" :formatter="formatSex" sortable>
        </el-table-column>
        <el-table-column prop="age" label="年龄" width="100" sortable>
        </el-table-column>
        <el-table-column prop="birth" label="生日" width="120" sortable>
        </el-table-column>
        <el-table-column prop="addr" label="地址" min-width="180" sortable>
        </el-table-column>
      </el-table>
    </template>

  </section>
</template>
<script>
  import { getUserList } from '../../api/test';
  // import { getUserList } from '../../api/user';
  //import NProgress from 'nprogress'
  export default {
    data() {
      return {
        filters: {
          name: ''
        },
        loading: false,
        users: [
        ],
        queryParam1:{}
      }
    },
    methods: {
      //点击行时获取参数
      getUrlParam(row,index){
        let queryKey=this.$store.state.urlParam.queryKey;
        let queryParam={};
        this.$store.state.urlParam.queryParam=queryParam;
        console.log("urlParam的key值:"+JSON.stringify(queryKey));
        console.log("urlParam的row值:"+JSON.stringify(row));
        console.log("urlParam的row值:"+index);
        // var str=eval(  '('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')'  );
        // console.log("拼接字符串:"+    '('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')'   );

        // this.$route.query=

        var str='(';
        str+= '{' ;
        console.log("拼接字符串的值1:"+str);
        for(var i=0;i<queryKey.length;++i){
          console.log("key值分别是:"+queryKey[i]);
          // console.log("urlParam的age值:"+row["age"]+"urlParam的name值:"+row["name"]);
          console.log("urlParam的动态值:"+row[queryKey[i]]);
          if(i+1<queryKey.length){
            str += '"'+queryKey[i]+'": "'+row[queryKey[i]]+'", ';
          }else{
            str += '"'+queryKey[i]+'": "'+row[queryKey[i]]+'"  ';
          }

          console.log("拼接字符串的值2:"+str);
        }
        str+=' }'    +')';
        console.log("拼接字符串的值3:"+str);
        console.log("拼接字符串的值4:"+eval(str));
        this.$store.state.urlParam.queryParam=eval(str);
        this.queryParam1=eval(str);
        console.log("queryParam路由参数1:"+JSON.stringify(this.$store.state.urlParam.queryParam));
        console.log("queryParam1路由参数2:"+JSON.stringify(this.queryParam1));
        console.log("路由参数3:"+JSON.stringify(this.$route.query));
        this.$router.push({
          path: '/user/ManyTable',
          query: this.queryParam1
        })
      },
      //性别显示转换
      formatSex: function (row, column) {
        return row.sex == 1 ? '男' : row.sex == 0 ? '女' : '未知';
      },
      //获取用户列表
      getUser: function () {
        let para = {
          name: this.filters.name
        };
        this.loading = true;
        //NProgress.start();
        getUserList(para).then((res) => {
          this.users = res.data.users;
          this.loading = false;
          //NProgress.done();
        });
      }
    },
    mounted() {
      this.getUser();
    }
  };

</script>
