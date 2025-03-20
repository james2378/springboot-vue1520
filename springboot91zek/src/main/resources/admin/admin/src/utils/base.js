const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot91zek/",
            name: "springboot91zek",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot91zek/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于springboot的公益服务平台的设计与实现"
        } 
    }
}
export default base
