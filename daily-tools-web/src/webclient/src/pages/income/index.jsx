import React from 'react';
import moment from 'moment';
import {Button, DatePicker, Form, Input, Layout, message, Radio, Typography} from 'antd';

const {Footer} = Layout;
const {Search} = Input;
const {Title, Text} = Typography;


export default class Index extends React.Component {
  state = {
    editing: {
      operateTime: null,
      operateType: 1,
      operateAmount: null,
    }
  }

  disabledDate = current => {
    // Can not select days before today and today
    return current && current > moment().endOf('day');
  }

  onOperateTimeChange = time => {
    this.state.editing.operateTime = time
    this.setState({...this.state})
  }

  onOperateTypeChange = event => {
    this.state.editing.operateType = event.target.value
    this.setState({...this.state})
  }

  operateAmountChange = event => {
    this.state.editing.operateAmount = event.target.value
    this.setState({...this.state})
  }

  addOperateRecord = () => {
    console.log(this.state.editing)
    this.state.editing.operateAmount = null
    this.setState({...this.state})

    message.success('添加成功!');
  }

  render() {
    return (
      <Layout style={{"height": "100%"}}>
        <Title level={3} style={{textAlign: "center", "margin": "40px 0"}}>收益计算器</Title>

        <div style={{textAlign: "center"}}>
          <Form
            name="basic"
            layout="horizontal"
            autoComplete="off"
            style={{display: "inline-block"}}>
            <Form.Item
              label="日期：">
              <DatePicker value={this.state.editing.operateTime}
                          onChange={this.onOperateTimeChange}
                          disabledDate={this.disabledDate}/>
            </Form.Item>

            <Form.Item
              label="类型：">
              <Radio.Group value={this.state.editing.operateType}
                           onChange={this.onOperateTypeChange}>
                <Radio value={1}>买入</Radio>
                <Radio value={2}>赎回</Radio>
              </Radio.Group>
            </Form.Item>

            <Form.Item
              label="金额：">
              <Input value={this.state.editing.operateAmount}
                     onChange={this.operateAmountChange}
                     type="number"
                     allowClear={true}
                     style={{width: 150, height: 30}}
                     prefix="￥"/>
            </Form.Item>

            <Form.Item>
              <Button type="primary"
                      disabled={!this.state.editing.operateTime || !this.state.editing.operateType || !this.state.editing.operateAmount}
                      onClick={this.addOperateRecord}>
                添加操作记录
              </Button>
            </Form.Item>
          </Form>
        </div>

        <Footer style={{textAlign: 'center', width: "100%", position: "absolute", bottom: 0}}>YD: 元·天，即投入金额与天数的乘积</Footer>
      </Layout>
    );
  }
}
