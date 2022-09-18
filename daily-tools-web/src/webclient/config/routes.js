export default [
  {
    path: '/',
    layout: false,
    routes: [
      {
        path: '/',
        name: 'index',
        component: './index'
      },
      {
        path: '/normalSaline',
        name: 'normalSaline',
        component: './normal-saline/index'
      },
      {
        path: '/income',
        name: 'income',
        component: './income/index'
      },
      {
        component: './404',
      },
    ],
  },

];
