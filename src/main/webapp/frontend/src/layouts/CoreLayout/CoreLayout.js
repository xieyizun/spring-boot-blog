import React, { Component } from 'react'
import PropTypes from 'prop-types'
import MyHeader from '../../components/Header'
import MyFooter from '../../components/Footer'
import MySider from '../../components/Sider'
import './CoreLayout.scss'
import '../../styles/core.scss'
import 'antd/dist/antd.css'
import { Layout, Breadcrumb } from 'antd'
const { Content } = Layout

export class CoreLayout extends Component {
  constructor(props) {
    super(props)
  }

  render() {
    return (
      <Layout style={{ minHeight: '100vh' }}>
        <MySider />
        <Layout>
          <MyHeader />
          <Content style={{margin: '0 16px' }}>
            <Breadcrumb style={{ margin: '16px 0' }}>
              <Breadcrumb.Item>User</Breadcrumb.Item>
              <Breadcrumb.Item>Bill</Breadcrumb.Item>
            </Breadcrumb>
            <div style={{ padding: 24, background: '#fff', minHeight: 360 }}>
              {this.props.children}
            </div>
          </Content>
          <MyFooter />
        </Layout>
      </Layout>)
  }
}

CoreLayout.propTypes = {
  children: PropTypes.element.isRequired
}

export default CoreLayout
