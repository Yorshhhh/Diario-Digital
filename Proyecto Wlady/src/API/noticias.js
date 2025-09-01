export const publicarNoticia = async (formData) => {
    try {
        const response = await fetch("http://localhost:8080/api/noticias/publicar-noticia", {
            method: "POST",
            body: formData,
        });

        if(!response.ok){
            throw new Error("Error desde el JS")
        }
         return await response.json()
    } catch (error) {
        console.error("Error desde el Catch: ", error)
    }
}