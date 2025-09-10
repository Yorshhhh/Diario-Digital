export const handleImagenChange = (e, setImagenes) => {
    setImagenes((prev) => [...prev, ...e.target.files])
}

export const handleAudioChange = (e, setAudios) => {
    setAudios((prev) => [...e.target.files])
}

export const handleVideoChange = (e, setVideos) => {
    setVideos((prev) => [...e.target.files])
}

export const handleCategoriaChange = (e, setCategoriaId) => {
    setCategoriaId(e.target.value)
    console.log(e.target.value)
}

export const eliminarImagen = (index) => {
    setImagenes((prev) => prev.filter((_, i) => i !== index))
}

export const eliminarAudio = (index) => {
    setAudios((prev) => prev.filter((_, i) => i !== index))
}

export const eliminarVideo = (index) => {
    setVideos((prev) => prev.filter((_, i) => i !== index))
}
