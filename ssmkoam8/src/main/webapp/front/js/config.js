
var projectName = '幼儿资源互助共享平台';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

{
	name: '我的订单',
	url: '../shop-order/list.html'
},

{
	name: '我的地址',
	url: '../shop-address/list.html'
},

{
        name: '我的收藏',
        url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '萌宝信息',
	url: './pages/mengbaoxinxi/list.html'
}, 
{
	name: '幼儿知识',
	url: './pages/youerzhishi/list.html'
}, 
{
	name: '保姆推荐',
	url: './pages/baomutuijian/list.html'
}, 
{
	name: '音频资源',
	url: './pages/yinpinziyuan/list.html'
}, 
{
	name: '二手商品',
	url: './pages/ershoushangpin/list.html'
}, 

{
	name: '交流论坛',
	url: './pages/forum/list.html'
}, 
]

var adminurl =  "http://localhost:8080/ssmkoam8/admin/dist/index.html";

var cartFlag = false

var chatFlag = false


cartFlag = true


var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"卖家","menuJump":"列表","tableName":"maijia"}],"menu":"卖家管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"咨询师","menuJump":"列表","tableName":"zixunshi"}],"menu":"咨询师管理"},{"child":[{"buttons":["查看","删除","查看评论"],"menu":"萌宝信息","menuJump":"列表","tableName":"mengbaoxinxi"}],"menu":"萌宝信息管理"},{"child":[{"buttons":["查看","删除","查看评论"],"menu":"幼儿知识","menuJump":"列表","tableName":"youerzhishi"}],"menu":"幼儿知识管理"},{"child":[{"buttons":["查看","删除","查看评论"],"menu":"保姆推荐","menuJump":"列表","tableName":"baomutuijian"}],"menu":"保姆推荐管理"},{"child":[{"buttons":["查看","删除","查看评论"],"menu":"音频资源","menuJump":"列表","tableName":"yinpinziyuan"}],"menu":"音频资源管理"},{"child":[{"buttons":["查看","删除","查看评论"],"menu":"二手商品","menuJump":"列表","tableName":"ershoushangpin"}],"menu":"二手商品管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"商品分类","menuJump":"列表","tableName":"shangpinfenlei"}],"menu":"商品分类管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"资源分类","menuJump":"列表","tableName":"ziyuanfenlei"}],"menu":"资源分类管理"},{"child":[{"buttons":["查看","删除"],"menu":"交流论坛","tableName":"forum"}],"menu":"交流论坛"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"萌宝信息列表","menuJump":"列表","tableName":"mengbaoxinxi"}],"menu":"萌宝信息模块"},{"child":[{"buttons":["查看"],"menu":"幼儿知识列表","menuJump":"列表","tableName":"youerzhishi"}],"menu":"幼儿知识模块"},{"child":[{"buttons":["查看"],"menu":"保姆推荐列表","menuJump":"列表","tableName":"baomutuijian"}],"menu":"保姆推荐模块"},{"child":[{"buttons":["查看"],"menu":"音频资源列表","menuJump":"列表","tableName":"yinpinziyuan"}],"menu":"音频资源模块"},{"child":[{"buttons":["查看"],"menu":"二手商品列表","menuJump":"列表","tableName":"ershoushangpin"}],"menu":"二手商品模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"萌宝信息","menuJump":"列表","tableName":"mengbaoxinxi"}],"menu":"萌宝信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"保姆推荐","menuJump":"列表","tableName":"baomutuijian"}],"menu":"保姆推荐管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"音频资源","menuJump":"列表","tableName":"yinpinziyuan"}],"menu":"音频资源管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"萌宝信息列表","menuJump":"列表","tableName":"mengbaoxinxi"}],"menu":"萌宝信息模块"},{"child":[{"buttons":["查看"],"menu":"幼儿知识列表","menuJump":"列表","tableName":"youerzhishi"}],"menu":"幼儿知识模块"},{"child":[{"buttons":["查看"],"menu":"保姆推荐列表","menuJump":"列表","tableName":"baomutuijian"}],"menu":"保姆推荐模块"},{"child":[{"buttons":["查看"],"menu":"音频资源列表","menuJump":"列表","tableName":"yinpinziyuan"}],"menu":"音频资源模块"},{"child":[{"buttons":["查看"],"menu":"二手商品列表","menuJump":"列表","tableName":"ershoushangpin"}],"menu":"二手商品模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"二手商品","menuJump":"列表","tableName":"ershoushangpin"}],"menu":"二手商品管理"},{"child":[{"buttons":["查看","删除"],"menu":"已发货订单","tableName":"orders/已发货"},{"buttons":["查看","删除"],"menu":"未支付订单","tableName":"orders/未支付"},{"buttons":["查看","删除"],"menu":"已取消订单","tableName":"orders/已取消"},{"buttons":["查看","删除","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"buttons":["查看","删除"],"menu":"已完成订单","tableName":"orders/已完成"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"萌宝信息列表","menuJump":"列表","tableName":"mengbaoxinxi"}],"menu":"萌宝信息模块"},{"child":[{"buttons":["查看"],"menu":"幼儿知识列表","menuJump":"列表","tableName":"youerzhishi"}],"menu":"幼儿知识模块"},{"child":[{"buttons":["查看"],"menu":"保姆推荐列表","menuJump":"列表","tableName":"baomutuijian"}],"menu":"保姆推荐模块"},{"child":[{"buttons":["查看"],"menu":"音频资源列表","menuJump":"列表","tableName":"yinpinziyuan"}],"menu":"音频资源模块"},{"child":[{"buttons":["查看"],"menu":"二手商品列表","menuJump":"列表","tableName":"ershoushangpin"}],"menu":"二手商品模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"卖家","tableName":"maijia"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"幼儿知识","menuJump":"列表","tableName":"youerzhishi"}],"menu":"幼儿知识管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"萌宝信息列表","menuJump":"列表","tableName":"mengbaoxinxi"}],"menu":"萌宝信息模块"},{"child":[{"buttons":["查看"],"menu":"幼儿知识列表","menuJump":"列表","tableName":"youerzhishi"}],"menu":"幼儿知识模块"},{"child":[{"buttons":["查看"],"menu":"保姆推荐列表","menuJump":"列表","tableName":"baomutuijian"}],"menu":"保姆推荐模块"},{"child":[{"buttons":["查看"],"menu":"音频资源列表","menuJump":"列表","tableName":"yinpinziyuan"}],"menu":"音频资源模块"},{"child":[{"buttons":["查看"],"menu":"二手商品列表","menuJump":"列表","tableName":"ershoushangpin"}],"menu":"二手商品模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"咨询师","tableName":"zixunshi"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
