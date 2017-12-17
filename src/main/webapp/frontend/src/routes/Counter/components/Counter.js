import React from 'react'
import PropTypes from 'prop-types'

export const Counter = (props) => (
  <div style={{ margin: '0 auto' }}>
    <h2>Counter: {props.counter.counter}</h2>
    <h2>from api: {props.counter.apiMsg}</h2>
    <button className='btn btn-default' onClick={props.increment}>
      Increment
    </button>
    {' '}
    <button className='btn btn-default' onClick={props.doubleAsync}>
      Double (Async)
    </button>
  </div>
)

Counter.propTypes = {
  doubleAsync: PropTypes.func.isRequired,
  increment: PropTypes.func.isRequired
}

export default Counter
