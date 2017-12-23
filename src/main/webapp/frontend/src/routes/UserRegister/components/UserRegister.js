import React, { Component } from 'react'
import { Input, Button, Icon } from 'antd'
import './UserRegister.scss'

export class UserRegister extends Component {
  constructor(props) {
    super(props)
  }

  render () {
    const { register } = this.props

    return (
      <div className={"register"}>
        <Input.Group>
          <Input
            placeholder="Enter your username"
            prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
          />
          <Input
            placeholder="Enter your username"
            prefix={<Icon type="mail" style={{ color: 'rgba(0,0,0,.25)' }} />}
          />
          <Input
            placeholder="Enter your username"
            prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
          />
        </Input.Group>
        <Button type="primary" onClick={() => { register && register() } }>注册</Button>
      </div>
    )
  }
}

export default UserRegister
