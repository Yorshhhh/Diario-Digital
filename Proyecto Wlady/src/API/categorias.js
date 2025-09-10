export const listarCategorias = async () => {
    try{
        const response = await fetch("http://localhost:8080/api/categorias/listar-categorias", {
            method: "GET"
        });

        if(!response.ok){
            throw new Error("Error desde el JS")
        }
        return await response.json();
    } catch(error){
        console.error("Error desde el Catch: ", error)
    }
}