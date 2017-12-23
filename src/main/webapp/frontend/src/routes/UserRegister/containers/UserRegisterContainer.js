import { connect } from 'react-redux'

import UserReigster from '../components/UserRegister'

import {
  register
} from '../modules/actions'


const mapDispatchToProps = {
  register
}

const mapStateToProps = (state) => ({
  register: state.register
})

export default connect(mapStateToProps, mapDispatchToProps)(UserReigster)


