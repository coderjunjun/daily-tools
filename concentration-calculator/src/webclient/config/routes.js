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
    ],
  },
  {
    component: './404',
  },
];
