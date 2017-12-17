import $ from 'jquery'
// ------------------------------------
// Constants
// ------------------------------------
export const COUNTER_INCREMENT = 'COUNTER_INCREMENT'
export const COUNTER_DOUBLE_ASYNC = 'COUNTER_DOUBLE_ASYNC'

// ------------------------------------
// Actions
// ------------------------------------
export function increment (value = 1) {
  return (dispatch, getState) => {
    $.ajax({
      url: '/hello'
    }).done(res => {
      console.log("=====", res)
      dispatch({
        type    : COUNTER_INCREMENT,
        payload : res.data
      })
    })
  }
}

/*  This is a thunk, meaning it is a function that immediately
 returns a function for lazy evaluation. It is incredibly useful for
 creating async actions, especially when combined with redux-thunk! */

export const doubleAsync = () => {
  return (dispatch, getState) => {
    return new Promise((resolve) => {
      setTimeout(() => {
        dispatch({
          type    : COUNTER_DOUBLE_ASYNC,
          payload : 'test'
        })
        resolve()
      }, 200)
    })
  }
}

export const actions = {
  increment,
  doubleAsync
}

// ------------------------------------
// Action Handlers
// ------------------------------------
const ACTION_HANDLERS = {
  [COUNTER_INCREMENT] : (state, action) => {
    console.log("========", action.payload)
    return { ...state, counter: state.counter+1, apiMsg: action.payload }
  },
  [COUNTER_DOUBLE_ASYNC] : (state, action) => {
    return { ...state, counter: state.counter+2, apiMsg: action.payload}
  }
}

// ------------------------------------
// Reducer
// ------------------------------------
const initialState = {
  counter: 0,
  apiMsg: ''
}
export default function counterReducer (state = initialState, action) {
  const handler = ACTION_HANDLERS[action.type]

  return handler ? handler(state, action) : state
}
