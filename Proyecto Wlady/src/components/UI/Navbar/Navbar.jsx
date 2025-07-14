import reactLogo from '/react.svg'
import viteLogo from '/vite.svg'
import { useContent } from '../../../context/ContentContext'
import './Navbar.css'

function Navbar() {
    const { setActiveContent } = useContent();

    return (
        <nav className='navbar'>
            <button onClick={() => setActiveContent('home')} className="nav-button">
                <img src={viteLogo} className="logo" alt="Vite logo" />
            </button>
            <button onClick={() => setActiveContent('deportes')} className="nav-button">Deportes</button>
            <button onClick={() => setActiveContent('videojuegos')} className="nav-button">Videojuegos</button>
            <button onClick={() => setActiveContent('publicar')} className='nav-button'>Publicar Noticia</button>
            <button onClick={() => setActiveContent('animes')} className="nav-button">
                <img src={reactLogo} className="logo react" alt="React logo" />
            </button>
        </nav>
    )
}


export default Navbar