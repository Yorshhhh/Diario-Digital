import { createRoot } from 'react-dom/client'
import { ContentProvider } from './context/ContentContext'
import './index.css'
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
  <ContentProvider>
    <App />
  </ContentProvider>
)