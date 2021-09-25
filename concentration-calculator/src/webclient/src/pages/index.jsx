import React from 'react';
import {Input, Typography} from 'antd';
import {Layout} from 'antd';

const {Footer} = Layout;
const {Search} = Input;
const {Title, Text} = Typography;


export default class Index extends React.Component {
  state = {
    saltWeight: 0
  }

  doCalc(waterWeight) {
    console.log(waterWeight)

    const FACTOR = 0.009
    let saltWeight = 0
    if (waterWeight) {
      saltWeight = waterWeight / (1 - FACTOR) - waterWeight
      saltWeight = parseFloat(saltWeight.toFixed(1)).toString()
    }

    const newState = {...this.state, saltWeight: saltWeight}
    this.setState(newState)
  }

  render() {
    return (
      <Layout style={{"height": "100%"}}>
        <Title level={3} style={{"text-align": "center", "margin": "40px 0"}}>生理盐水计算器</Title>

        <div className="site-layout" style={{"padding": "0 20px"}}>
          <Search
            placeholder="输入水量（单位: ml）"
            allowClear
            enterButton="计算"
            size="large"
            type="number"
            onSearch={this.doCalc.bind(this)}
          />
        </div>

        <div style={{"margin-top": "80px", textAlign: "center"}}>
          <Text type="success" style={{fontSize: "25px"}}>所需盐量：{this.state.saltWeight}g</Text>
        </div>

        <Footer style={{textAlign: 'center', width: "100%", position: "absolute", bottom: 0}}>生理盐水：浓度0.9%的NaCl溶液</Footer>
      </Layout>
    );
  }
}
