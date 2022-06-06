/**
 * @param {string] link
 * @return {Promise<strnig>} linkMobileBasic
*/
export default (link) => {
	 return new Promise(async resolve => {
		const lien = 'https://mbasic.'+link.split('www.')[1] 
		resolve(lien)
	})
}
