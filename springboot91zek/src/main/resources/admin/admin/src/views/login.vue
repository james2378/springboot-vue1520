<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221201/ad8b598515704341aed4de6f4d3b36b8.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>

      <el-form :style='{"minHeight":"750px","padding":"40px 0px 60px 560px","margin":"40px auto 0 auto","borderRadius":"4px","background":"url(http://codegen.caihongy.cn/20221130/96464fa9ee1447fcac8ed4cef9e06ae1.png) no-repeat right top","width":"1200px","backgroundSize":"auto 100%","height":"auto"}'>
        <div v-if="true" :style='{"width":"80%","margin":"40px 0px 30px 30px","lineHeight":"44px","fontSize":"20px","color":"#160f53","textAlign":"center"}' class="title-container">基于springboot的公益服务平台的设计与实现登录</div>
        <div class="list-item" :style='{"width":"80%","margin":"0 auto 40px","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"#160f53"}'>用户名</div>
          <input :style='{"padding":"0 20px","borderColor":"#d0cddb","color":"#999","borderRadius":"0px","borderWidth":"0 0 1px","width":"360px","fontSize":"14px","borderStyle":"solid","height":"44px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div class="list-item" :style='{"width":"80%","margin":"0 auto 40px","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"#160f53"}'>密码：</div>
          <input :style='{"padding":"0 20px","borderColor":"#d0cddb","color":"#999","borderRadius":"0px","borderWidth":"0 0 1px","width":"360px","fontSize":"14px","borderStyle":"solid","height":"44px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>
        <div :style='{"width":"80%","margin":"30px auto"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>
        <div :style='{"width":"550px","margin":"80px auto 0 6px","alignItems":"left","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
          <el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"0px","background":"#41bec9","width":"auto","fontSize":"14px","height":"40px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-button :style='{"border":"1px solid #41bec9","cursor":"pointer","padding":"0 10px","margin":"0 5px","outline":"none","color":"#41bec9","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' type="primary" @click="register('yonghu')" class="register">注册用户</el-button>
          <el-button :style='{"border":"1px solid #41bec9","cursor":"pointer","padding":"0 10px","margin":"0 5px","outline":"none","color":"#41bec9","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' type="primary" @click="register('zhiyuanzhe')" class="register">注册志愿者</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>

import menu from "@/utils/menu";

export default {
  data() {
    return {
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      roles: [],
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {
    this.getRandCode()
  },
  destroyed() {
	    },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
        this.$storage.set("pageFlag", "register");
		this.$router.push({path:'/register'})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}

		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/index/" });
			} else {
				this.$message.error(data.msg);
			}
		});
    },
    getRandCode(len = 4){
		this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random()*chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random()*colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random()*60)
        let plus = Math.floor(Math.random()*2)
        if(plus == 1) rotate = '-'+rotate
        this.codes[i].rotate = 'rotate('+rotate+'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random()*sizes.length)
        this.codes[i].size = sizes[size]+'px'
      }
    },
  }
};
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20221201/ad8b598515704341aed4de6f4d3b36b8.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		border-radius: 0px;
		padding: 0 20px;
		color: #999;
		width: 360px;
		font-size: 14px;
		border-color: #d0cddb;
		border-width: 0 0 1px;
		border-style: solid;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border-radius: 0px;
  	  	padding: 0 20px;
  	  	outline: none;
  	  	margin: 0 20px 0 0;
  	  	color: #666;
  	  	width: 325px;
  	  	font-size: 14px;
  	  	border-color: #d0cddb;
  	  	border-width: 0 0 1px;
  	  	border-style: solid;
  	  	height: 40px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #666;
        border-color: #555;
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: #333;
        font-size: 14px;
      }
}
</style>
