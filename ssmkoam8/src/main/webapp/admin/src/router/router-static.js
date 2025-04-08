import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import maijia from '@/views/modules/maijia/list'
    import discussershoushangpin from '@/views/modules/discussershoushangpin/list'
    import youerzhishi from '@/views/modules/youerzhishi/list'
    import forum from '@/views/modules/forum/list'
    import yinpinziyuan from '@/views/modules/yinpinziyuan/list'
    import discussmengbaoxinxi from '@/views/modules/discussmengbaoxinxi/list'
    import mengbaoxinxi from '@/views/modules/mengbaoxinxi/list'
    import zixunshi from '@/views/modules/zixunshi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import ershoushangpin from '@/views/modules/ershoushangpin/list'
    import orders from '@/views/modules/orders/list'
    import discussbaomutuijian from '@/views/modules/discussbaomutuijian/list'
    import baomutuijian from '@/views/modules/baomutuijian/list'
    import ziyuanfenlei from '@/views/modules/ziyuanfenlei/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/maijia',
        name: '卖家',
        component: maijia
      }
      ,{
	path: '/discussershoushangpin',
        name: '二手商品评论',
        component: discussershoushangpin
      }
      ,{
	path: '/youerzhishi',
        name: '幼儿知识',
        component: youerzhishi
      }
      ,{
	path: '/forum',
        name: '交流论坛',
        component: forum
      }
      ,{
	path: '/yinpinziyuan',
        name: '音频资源',
        component: yinpinziyuan
      }
      ,{
	path: '/discussmengbaoxinxi',
        name: '萌宝信息评论',
        component: discussmengbaoxinxi
      }
      ,{
	path: '/mengbaoxinxi',
        name: '萌宝信息',
        component: mengbaoxinxi
      }
      ,{
	path: '/zixunshi',
        name: '咨询师',
        component: zixunshi
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/ershoushangpin',
        name: '二手商品',
        component: ershoushangpin
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/discussbaomutuijian',
        name: '保姆推荐评论',
        component: discussbaomutuijian
      }
      ,{
	path: '/baomutuijian',
        name: '保姆推荐',
        component: baomutuijian
      }
      ,{
	path: '/ziyuanfenlei',
        name: '资源分类',
        component: ziyuanfenlei
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
