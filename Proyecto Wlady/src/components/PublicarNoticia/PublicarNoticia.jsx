import { useState, useEffect } from 'react'
import { publicarNoticia } from '../../API/noticias'
import { listarCategorias } from '../../API/categorias'
import { handleImagenChange, handleAudioChange, handleVideoChange, handleCategoriaChange, eliminarImagen, eliminarAudio, eliminarVideo } from './handlers'

import './PublicarNoticia.css'

function PublicarNoticia() {
    const [titular, setTitular] = useState('')
    const [lead, setLead] = useState('')
    const [cuerpoNoticia, setCuerpo] = useState('')
    const [categoria, setCategoria] = useState([])
    const [categoriaId, setCategoriaId] = useState('')
    const [imagenes, setImagenes] = useState([])
    const [audios, setAudios] = useState([])
    const [videos, setVideos] = useState([])

    useEffect(() => {
        const fetchCategorias = async () => {
            try {
                const data = await listarCategorias();
                console.log(data);
                setCategoria(data);
            } catch (error) {
                console.error("Error cargando categorias: ", error)
            }
        }
        fetchCategorias();
    }, [])

    const handleSubmit = async (e) => {
        e.preventDefault()
        const formData = new FormData();

        formData.append("titular", titular)
        formData.append("lead", lead)
        formData.append("cuerpoNoticia", cuerpoNoticia)
        formData.append("categoriaId", categoriaId)

        imagenes.forEach((img) => formData.append("imagenes", img));
        audios.forEach((audio) => formData.append("audios", audio));
        videos.forEach((video) => formData.append("videos", video));

        //ENVIAR FORMULARIO
        try {
            const noticiaPublicada = await publicarNoticia(formData)

            setTitular("");
            setLead("");
            setCuerpo("");
            setCategoria("");
            setImagenes([]);
            setAudios([]);
            setVideos([]);
        } catch (error) {
            console.error("Nos lleva la chingada: ", error)
        }
    }

    return (
        <form className="form-noticia" onSubmit={handleSubmit}>
            <h2>Publicar nueva noticia</h2>

            <label htmlFor="titular">Titular</label>
            <input
                type="text"
                id="titular"
                value={titular}
                onChange={(e) => setTitular(e.target.value)}
                required
            />

            <label htmlFor="lead">Lead (resumen breve)</label>
            <input
                type="text"
                id="lead"
                value={lead}
                onChange={(e) => setLead(e.target.value)}
                required
            />

            <label htmlFor="cuerpoNoticia">Cuerpo de la noticia</label>
            <textarea
                id="cuerpoNoticia"
                value={cuerpoNoticia}
                onChange={(e) => setCuerpo(e.target.value)}
                rows="10"
                required
            ></textarea>
            <label htmlFor='categoria'>Categoría Noticiosa</label>
            <select value={categoriaId} onChange={(e) => handleCategoriaChange(e, setCategoriaId)}>
                <option value="">-- Selecciona Categoría</option>
                {categoria.map((cat) => (
                    <option key={cat.categoriaId} value={cat.categoriaId}>
                        {cat.nombreCategoria} - {cat.descripcionCategoria}
                    </option>
                ))}
            </select>

            <label htmlFor="imagenes">Imágenes</label>
            <input
                type="file"
                id="imagenes"
                multiple
                accept="image/*"
                onChange={(e) => handleImagenChange(e, setImagenes)}
            />

            {imagenes.length > 0 && (
                <div className="preview-imagenes">
                    {Array.from(imagenes).map((img, index) => (
                        <div key={index} style={{ display: 'inline-block', margin: '0.5rem', position: 'relative' }}>
                            <img
                                src={URL.createObjectURL(img)}
                                alt={`preview-${index}`}
                                style={{ width: '120px', borderRadius: '8px' }}
                            />
                            <button
                                type="button"
                                onClick={() => eliminarImagen(index)}
                                style={{
                                    position: 'absolute',
                                    top: 0,
                                    right: 0,
                                    background: 'red',
                                    color: 'white',
                                    border: 'none',
                                    borderRadius: '50%',
                                    cursor: 'pointer',
                                    width: '20px',
                                    height: '20px'
                                }}
                            >
                            </button>
                        </div>
                    ))}
                </div>
            )}

            <label htmlFor="audios">Audios</label>
            <input type="file"
                id='audios'
                multiple
                accept='audio/*'
                onChange={(e) => handleAudioChange(e, setAudios)}
            />
            {audios.length > 0 && (
                <div className='preview-audios'>
                    {Array.from(audios).map((audio, index) => (
                        <div key={index} style={{ display: 'inline-block', margin: '0.5rem', position: 'relative' }}>
                            <audio key={index}
                                controls
                                src={URL.createObjectURL(audio)}
                                style={{ margin: '0.5rem' }}
                            />
                            <button
                                type="button"
                                onClick={() => eliminarAudio(index)}
                                style={{
                                    position: 'absolute',
                                    top: 0,
                                    right: 0,
                                    background: 'red',
                                    color: 'white',
                                    border: 'none',
                                    borderRadius: '50%',
                                    cursor: 'pointer',
                                    width: '20px',
                                    height: '20px'
                                }}
                            >
                            </button>
                        </div>

                    ))}

                </div>
            )}

            <label htmlFor='videos'>Videos</label>
            <input type="file" id='videos' multiple accept='video/*'
                onChange={(e) => handleVideoChange(e, setVideos)} />

            {videos.length > 0 && (
                <div className='preview-videos'>
                    {Array.from(videos).map((video, index) => (
                        <div key={index} style={{ display: 'inline-block', margin: '0.5rem', position: 'relative' }}>
                            <video key={index} controls width="200" style={{ margin: '0.5rem' }}>
                                <source src={URL.createObjectURL(video)} type={video.type} />
                                Tu navegador no soporta la etiqueta de video
                            </video>
                            <button
                                type="button"
                                onClick={() => eliminarVideo(index)}
                                style={{
                                    position: 'absolute',
                                    top: 0,
                                    right: 0,
                                    background: 'red',
                                    color: 'white',
                                    border: 'none',
                                    borderRadius: '50%',
                                    cursor: 'pointer',
                                    width: '20px',
                                    height: '20px'
                                }}
                            >
                            </button>
                        </div>

                    ))}
                </div>
            )}
            <button type="submit">Publicar noticia</button>
        </form>
    )
}

export default PublicarNoticia