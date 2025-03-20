<template>
	<div style="height: 100%;">
		<index-aside v-if="'vertical' == 'vertical'" :style='{"boxShadow":"2px -2px 4px rgba(0, 0, 0, .1)","padding":"34px 0 140px","borderColor":"#666","bottom":"0","overflow":"hidden","top":"84px","borderRadius":"0","left":"0","background":"url(http://codegen.caihongy.cn/20221130/90e2a691636e4afcbe4831a09af517f0.png) no-repeat left bottom,linear-gradient(180deg, rgba(42,219,203,1) 0%, rgba(152,122,222,1) 100%)","borderWidth":"0 0px 0 0","width":"240px","fontSize":"0px","position":"fixed","borderStyle":"solid","height":"100%","zIndex":"1001"}'></index-aside>
		<el-main :style='"vertical" == "vertical" ? {"minHeight":"100%","padding":"10px 0 0 250px","margin":"0","position":"relative","background":"url(http://codegen.caihongy.cn/20221130/6d1615d3271e4d7a87377d1c2599719a.png) fixed,linear-gradient(60deg, rgba(220,246,244,1) 0%, rgba(249,247,255,1) 100%)","display":"block"} : {"minHeight":"100%","margin":"0","position":"relative"}'>
			<index-header :style='{"boxShadow":"0 0px 0px rgba(0, 0, 0, .3)","padding":"0 20px 0 0","alignItems":"center","top":"0","borderRadius":"0 0 50px 50px","left":"0","background":"url(http://codegen.caihongy.cn/20221130/046ea1527da844ca86a03beb9d358d58.png) no-repeat center top,linear-gradient(0deg, rgba(42,219,203,1) 0%, rgba(152,122,222,1) 100%)","display":"block","width":"calc(100% - 0px)","position":"fixed","zIndex":"1001","height":"64px"}'></index-header>
			<index-aside v-if="'vertical' == 'horizontal'" :style='{"width":"100%","borderColor":"#efefef","borderStyle":"solid","background":"#304156","borderWidth":"0 0 1px 0","height":"auto"}'></index-aside>
			<bread-crumbs :title="title" :style='{"padding":"0px 15px","boxShadow":"0 4px 2px #bcdedb","margin":"74px 0 0 30px","borderColor":"#d8e7f3 #d8e7f3 #cce2f4","borderRadius":"0","borderWidth":"0px 0 0px","background":"#2adbcb","width":"calc(100% - 60px)","lineHeight":"44px","borderStyle":"solid","height":"44px"}' class="bread-crumbs"></bread-crumbs>
			<router-view :style='{"padding":"10px 30px"}' class="router-view" style="height:auto;background: transparent;"></router-view>
		</el-main>
	</div>
</template>

<script>
	import IndexAside from '@/components/index/IndexAsideStatic'
	import IndexHeader from '@/components/index/IndexHeader'
	import menu from "@/utils/menu";
	export default {
		components: {
			IndexAside,
			IndexHeader
		},
		data() {
			return {
				menuList: [],
				role: "",
				currentIndex: -2,
				itemMenu: [],
				title: '',
			};
		},
		mounted() {
			let menus = menu.list();
			this.menuList = menus;
			this.role = this.$storage.get("role");
		},
		created() {
			this.init();
		},
		methods: {
			init(){
				this.$nextTick(()=>{
					
				})
			},
			menuHandler(menu) {
				this.$router.push({
					name: menu.tableName
				});
				this.title = menu.menu;
			},
			titleChange(index, menus) {
				this.currentIndex = index
				this.itemMenu = menus;
				console.log(menus);
			},
			homeChange(index) {
				this.itemMenu = [];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
			},
			centerChange(index) {
				this.itemMenu = [{
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "修改密码",
					"tableName": "updatePassword"
				}, {
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "个人信息",
					"tableName": "center"
				}];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
				
			}
		}
	};
</script>
<style lang="scss" scoped>
	a {
		text-decoration: none;
		color: #555;
	}

	a:hover {
		background: #00c292;
	}
	
	.el-main {
		padding: 0;
		display: block;
	}

	.nav-list {
		width: 100%;
		margin: 0 auto;
		text-align: left;
		margin-top: 20px;

		.nav-title {
			display: inline-block;
			font-size: 15px;
			color: #333;
			padding: 15px 25px;
			border: none;
		}

		.nav-title.active {
			color: #555;
			cursor: default;
			background-color: #fff;
		}
	}

	.nav-item {
		margin-top: 20px;
		background: #FFFFFF;
		padding: 15px 0;

		.menu {
			padding: 15px 25px;
		}
	}
	
	.detail-form-content {
	    background: transparent;
	}
</style>
