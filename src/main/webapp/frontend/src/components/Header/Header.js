import React, { Component } from 'react'
import { IndexLink, Link } from 'react-router'
import './Header.scss'
import { Layout } from 'antd'
const { Header } = Layout

export class MyHeader extends Component {
  constructor(props) {
    super(props)
  }

  render () {
    return (
      <Header style={{background: '#fff', padding: 0}}>
        <div className={"pull-left"}>
          <IndexLink to='/' activeClassName='route--active'>
            主页
          </IndexLink>
          <Link to='/notFound' activeClassName='route--active'>
            关于
          </Link>
        </div>
        <div className={"pull-right"}>
          <Link to='/register' activeClassName='route--active'>
            注册
          </Link>
          <Link to='/notFound' activeClassName='route--active'>
            登录
          </Link>
        </div>
      </Header>
  )}
}

export default MyHeader
