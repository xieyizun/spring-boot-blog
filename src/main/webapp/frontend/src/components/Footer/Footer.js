import React, { Component } from 'react'
import './Footer.scss'
import { Layout } from 'antd'
const { Footer } = Layout

export class MyFooter extends Component {
  constructor(props) {
    super(props)
  }

  render () {
    return (
      <Footer style={{ textAlign: 'center' }}>
        Ant Design ©2016 Created by Ant UED
      </Footer>
    )}
}

export default MyFooter
