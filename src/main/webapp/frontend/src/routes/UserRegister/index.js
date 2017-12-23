import { injectReducer } from '../../store/reducers'

export default (store) => ({
  path: 'register',
  getComponent (nextState, cb) {
    require.ensure([], (require) => {
      const Zen = require('./containers/UserRegisterContainer').default
      const reducer = require('./modules/actions').default
      injectReducer(store, { key: 'register', reducer })
      cb(null, Zen)
    })
  }
})
