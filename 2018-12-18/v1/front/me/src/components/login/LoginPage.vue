<template>
    <div class="login">
      <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" labelPosition="center" label-width="0px" class="demo-ruleForm login-container">
        <div class="login-box">
          <h4 class="title">用户登录</h4>
          <el-form-item prop="username">
            <el-input type="text" v-model="ruleForm2.username" auto-complete="off" placeholder="账号"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" v-model="ruleForm2.password" auto-complete="off" placeholder="密码"></el-input>
          </el-form-item>
          <el-checkbox v-model="checked" class="remember">记住密码</el-checkbox>
          <el-form-item style="width:100%;">
            <el-button type="primary" style="width:100%;" @click="loginSubmit('ruleForm2')">登录</el-button>
          </el-form-item>
        </div>
      </el-form>
    </div>
</template>
<script>
    export default {
      data() {
            return {
              ruleForm2: {
                username: '',
                password: ''
              },
              rules2: {
                username: [{
                  required: true,
                  message: '请输入账号',
                  trigger: 'blur'
                }],
                password: [{
                  required: true,
                  message: '请输入密码',
                  trigger: 'blur'
                }]
              }
            }
        },
      methods: {
        // 登录
        loginSubmit (name) {
          this.$refs[name].validate((valid) => {
            if(valid){
              let user = {};
              let loginInfo = JSON.stringify(this.ruleForm2);
              sessionStorage.setItem('user', JSON.stringify(user));
              this.$router.push({
                  name: 'Home'
              })
            }
          })
        }
      }
    }
</script>

<style lang="less" scoped="">
  .login {
    width: 100%;
    min-width: 1200px;
    height: 100%;
    min-height: 500px;
    overflow: auto;
    background: burlywood;
    background-size: cover;
    position: relative;
    .login-container {
      position: absolute;
      top: 0;
      right: 30%;
      background: rgba(235, 240, 250, .9);
      width: 350px;
      height: 100%;
      border-left: 1px solid #eaeaea;
      border-right: 1px solid #eaeaea;
      .login-box{
        height:-moz-calc(100% - 30%);
        height:-webkit-calc(100% - 30%);
        height: calc(100% - 30%);
        margin-top: 30%;
        padding: 0 30px 0 30px;
        .title {
          margin: 0 auto 25px auto;
          text-align: center;
          color: #505458;
        }
        .remember {
          margin: 0 0 20px 0;
        }
      }
    }
  }

</style>
