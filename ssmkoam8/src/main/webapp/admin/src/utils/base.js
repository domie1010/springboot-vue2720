const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmkoam8/",
            name: "ssmkoam8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmkoam8/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "幼儿资源互助共享平台"
        } 
    }
}
export default base
