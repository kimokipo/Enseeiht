import interface1 from "./api/interface.js"
(async () => {
  await interface1.init();
  await interface1.visitPage("https://sunilsandhu.com");
})();
