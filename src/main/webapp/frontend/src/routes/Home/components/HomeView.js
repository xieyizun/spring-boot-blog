import React, { Component } from 'react'
import DuckImage from '../assets/Duck.jpg'
import './HomeView.scss'

export class HomeView extends Component {
  constructor(props) {
    super(props)
  }

  render () {
    return (
      <div>
        <h4>This is a duck, because Redux!</h4>
        <img className='duck' src={DuckImage} />
      </div>
    )
  }
}

export default HomeView
