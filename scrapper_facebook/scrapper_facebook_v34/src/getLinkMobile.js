/**
 * @param {string] link
 * @return {Promise<strnig>} linkMobile
*/
export default (link) => {
	 return new Promise(async resolve => {
		const lien = 'https://m.'+link.split('www.')[1] 
		resolve(lien)
	})
}
