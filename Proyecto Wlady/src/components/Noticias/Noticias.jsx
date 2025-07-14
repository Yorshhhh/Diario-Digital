import './Noticias.css'
import { useEffect, useState } from 'react'
import Noticia from '../Noticia/Noticia'

function Noticias({ activeContent, setActiveContent }) {
    const [noticiasData, setNoticiasData] = useState([])

    // Simula una "llamada a una API"
    useEffect(() => {
        setTimeout(() => {
            const noticiasSimuladas = [
                {
                    id: 1,
                    categoria: 'deportes',
                    titulo: 'River vence a Boca',
                    resumen: 'River Plate ganó 2-1 en el Superclásico.',
                    imagen: 'bocavsriver.jpg'
                },
                {
                    id: 2,
                    categoria: 'videojuegos',
                    titulo: 'Remaster de Oblivion',
                    resumen: 'Éxito en ventas tras un mes de su lanzamiento.',
                    imagen: 'oblivion.jpg'
                },
                {
                    id: 3,
                    categoria: 'animes',
                    titulo: 'Final de Solo Leveling',
                    resumen: 'Culmina la segunda temporada del anime.',
                    imagen: 'solo_leveling_03_ivrea.jpg'
                }
            ]
            setNoticiasData(noticiasSimuladas)
        }, 1000) // Simula 1 segundo de carga
    }, [])

    const noticiaActual = noticiasData.find(noticia => noticia.categoria === activeContent)

    return (
        <section className={`contenido ${['deportes', 'videojuegos', 'animes'].includes(activeContent) ? 'detalle' : ''}`}>
            {activeContent === 'home' && (
                <>
                    <div className='noticiaPrincipal fade-in' onClick={() => {
                        setActiveContent('animes')
                    }} style={{ cursor: 'pointer' }}>

                        <h1>Proyecto Periodismo Wladimir</h1>
                        <img src="solo_leveling_03_ivrea.jpg" target="_blank" rel="noopener noreferrer" alt="" />
                        <p>Ha concluido la segunda temporada del famoso anime Solo Leveling!</p>
                    </div>

                    <div className='noticiaPreview fade-in' onClick={() => {
                        setActiveContent('deportes')
                    }}>
                        <h1>Deportes</h1>
                        <img src="bocavsriver.jpg" alt="" />
                        <p>El clásico jugado en el estadio monumental ha finalizado con la victoria 2-1 de River Plate contra Boca Juniors!</p>
                    </div>

                    <div className='noticiaPreview fade-in' onClick={() => {
                        setActiveContent('videojuegos')
                    }}>
                        <h1>Videojuegos</h1>
                        <img src="oblivion.jpg" alt="" />
                        <p>El Remaster del videojuego The Elder Scrolls: Oblivion ha sido un completo éxito a un mes de su estreno!</p>
                    </div>

                    <div className='noticiaPreview fade-in' onClick={() => {
                        setActiveContent('animes')
                    }}>
                        <h1>Anime</h1>
                        <img src="steelballrun.jpg" alt="" />
                        <p>La tasa de la depresión mundial ha llegado a 0% con el anuncio del capítulo 7 de Jojo´s Bizarre Adventure: Steel Ball Run!</p>
                    </div>
                </>
            )}
            {['deportes', 'videojuegos', 'animes'].includes(activeContent) && noticiaActual && (
                <div className='noticiaContenedor'>
                    <Noticia data={noticiaActual} />
                </div>
            )}
        </section>
    )
}

export default Noticias