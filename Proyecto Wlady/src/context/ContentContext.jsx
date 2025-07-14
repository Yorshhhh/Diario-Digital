import { createContext, useState, useContext } from 'react'

const ContentContext = createContext();

export function ContentProvider({ children }) {
    const [activeContent, setActiveContent] = useState('home');

    return (
        <ContentContext.Provider value={{ activeContent, setActiveContent }}>
            {children}
        </ContentContext.Provider>
    )
}

export function useContent(){
    const context = useContext(ContentContext)

    if(!context){
        throw new Error('useContent solo puede usarse dentro del context')
    }
    return context
}