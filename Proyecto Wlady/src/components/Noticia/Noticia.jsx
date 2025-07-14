import './Noticia.css'

function Noticia({ data }) {
  return (
    <article className='fade-in articulo'>
      <header className='encabezado'>
        <h1 className='titulo'>{data.titulo}</h1>
      </header>

      <figure className='img-contenedor'>
        <img src={data.imagen} alt={data.titulo} className='foto' />
        <figcaption className='pieImagen'>Fuente: {data.fuente || 'Imagen referencial'}</figcaption>
      </figure>

      <section className='historia'>
        <p>{data.resumen}</p>
      </section>


    </article>
  )
}

export default Noticia