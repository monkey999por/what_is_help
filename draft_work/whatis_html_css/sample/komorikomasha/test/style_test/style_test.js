const footSpace = document.querySelector(".foot_space");

document.querySelector(".add_footer_element").addEventListener(
  "click",
  (e) => {
    footSpace.innerHTML = "<p class='beautifull_button'>Button</p>";
  },
  false
);

document.querySelector(".delete_footer_element").addEventListener(
  "click",
  (e) => {
    footSpace.children.item(0).remove();
  },
  false
);
