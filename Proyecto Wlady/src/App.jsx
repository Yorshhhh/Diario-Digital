import { useContent } from './context/ContentContext'
import Navbar from './components/UI/Navbar/Navbar'
import Noticias from './components/Noticias/Noticias'
import PublicarNoticia from './components/PublicarNoticia/PublicarNoticia'
//import reactLogo from './assets/react.svg'
import './App.css'

function App() {
  const { setActiveContent,activeContent } = useContent();

  return (
    <>
      <Navbar setActiveContent={setActiveContent} />

      {activeContent === 'home' || ['deportes', 'videojuegos', 'animes'].includes(activeContent) ? (
        <Noticias activeContent={activeContent} setActiveContent={setActiveContent} />
      ) : null}

      {activeContent === 'publicar' && (
        <PublicarNoticia />
      )}

    </>
  )
}

export default App
