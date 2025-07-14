import { useState } from 'react'
import './PublicarNoticia.css'

function PublicarNoticia() {
    const [titular, setTitular] = useState('')
    const [lead, setLead] = useState('')
    const [cuerpo, setCuerpo] = useState('')
    const [imagenes, setImagenes] = useState([])

    const handleImagenChange = (e) => {
        setImagenes([...e.target.files])
    }

    const handleSubmit = (e) => {
        e.preventDefault()

        const nuevaNoticia = {
            titular,
            lead,
            cuerpo,
            imagenes
        }

        console.log('Noticia publicada:', nuevaNoticia)

        // Aquí podrías enviar los datos al backend con fetch o axios

        // Resetear formulario (opcional)
        setTitular('')
        setLead('')
        setCuerpo('')
        setImagenes([])
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

            <label htmlFor="cuerpo">Cuerpo de la noticia</label>
            <textarea
                id="cuerpo"
                value={cuerpo}
                onChange={(e) => setCuerpo(e.target.value)}
                rows="10"
                required
            ></textarea>

            <label htmlFor="imagenes">Imágenes</label>
            <input
                type="file"
                id="imagenes"
                multiple
                accept="image/*"
                onChange={handleImagenChange}
            />

            {imagenes.length > 0 && (
                <div className="preview-imagenes">
                    {Array.from(imagenes).map((img, index) => (
                        <img
                            key={index}
                            src={URL.createObjectURL(img)}
                            alt={`preview-${index}`}
                            style={{ width: '100px', margin: '0.5rem' }}
                        />
                    ))}
                </div>
            )}

            <button type="submit">Publicar noticia</button>
        </form>
    )
}

export default PublicarNoticia