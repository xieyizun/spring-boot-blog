const REGISTER = 'REGISTER'

export function register() {
  return (dispatch, getState) => {
    dispatch({
      TYPE: REGISTER,
      payload: {}
    })
  }
}

export const actions = {
  register
}

// ------------------------------------
// Action Handlers
// ------------------------------------
const ACTION_HANDLERS = {
  [REGISTER]: (state) => {
    return ({...state})
  }
}

// ------------------------------------
// Reducer
// ------------------------------------
const initialState = {

}
export default function (state = initialState, action) {
  const handler = ACTION_HANDLERS[action.type]

  return handler ? handler(state, action) : state
}

