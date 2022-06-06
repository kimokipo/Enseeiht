import Author from './Author.js'
import Comment from './Comment.js'

export default class Post {
    
    /** @type {Author} */
    author

    /** @type {string} */
    link

    /** @type {Comment[]} */
    comments

    /** @type {Author[]} */
    likeurs

    /** @type {Author[]} */
    partageurs
	
    /** @type {string} */
    contenu

    /**
     * @param {Author} author 
     * @param {string} link 
     * @param {Comment[]} comments 
     * @param {Author[]} likeurs
     * @param {Author[]} partageurs 
     * @param {string} contenu
     */
    constructor(author, link, comments,likeurs,partageurs,contenu) {
        this.author = author
        this.link = link
        this.comments = comments
        this.likeurs = likeurs
        this.partageurs = partageurs
	this.contenu = contenu
    }
}
