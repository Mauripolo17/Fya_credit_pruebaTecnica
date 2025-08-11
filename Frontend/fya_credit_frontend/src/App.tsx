import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './components/Header'
import CreditForm from './components/Form'
import Home from './pages/Home'

function App() {

  return (
    <>
      <Header />
      <Home />
    </>

  )
}

export default App
