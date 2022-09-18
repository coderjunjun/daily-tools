import React from 'react';
import {Input, Layout, Typography} from 'antd';

const {Footer} = Layout;
const {Search} = Input;
const {Title, Text} = Typography;

export default class Index extends React.Component {

  render() {
    return (
      <Layout style={{"height": "100%"}}>
        <Title level={3} style={{"text-align": "center", "margin": "40px 0"}}>页面不存在!</Title>
      </Layout>
    );
  }
}
