console.log("Script Loaded");

//change theme work
let currentTheme = getTheme();

// initial theme
document.addEventListener('DOMContentLoaded', () =>{
    changeTheme()
});
//TODO
function changeTheme(){
    //set To Web page
    changePageTheme(currentTheme,currentTheme);

    //set the listener to change theme button
    const changeThemeButton =  document.querySelector('#change_theme_button');
    changeThemeButton.addEventListener("click", (event) =>{
        let oldTheme = currentTheme;
        
        console.log("change theme button clicked");

        
        //login to light
        if(currentTheme == "dark"){
            
            //theme to light
            currentTheme = "light"
        }
        else{
            //theme to dark
            currentTheme = "dark"
        }
        //change
        changePageTheme(currentTheme,oldTheme);
    });
    
}
//set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//get theme to local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme?theme: "light";
}
// sol : localStorage.setItem("theme","light") //you can check by writing the code in console

//change current page theme
function changePageTheme(theme,oldTheme){
    
        //update in local storage
        setTheme(currentTheme);

        //remove the old theme
        document.querySelector("html").classList.remove(oldTheme);

        //add current theme
        document.querySelector("html").classList.add(theme);

        //change the text
        document.querySelector('#change_theme_button').
        querySelector("span").textContent = theme == "light"?"Dark":"Light";

}