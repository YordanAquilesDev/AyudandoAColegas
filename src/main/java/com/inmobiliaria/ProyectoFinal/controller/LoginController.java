package com.inmobiliaria.ProyectoFinal.controller;

@Controller
@RequestMapping("iniciar_sesion")
public class LoginController{
    LoginService loginService;

    @PostMapping("/autenticarse")
    public String iniciarSesion(@RequestParam("usuario") String user,
                              @RequestParam("password") String password)
    {
        if(TienePermizo(user,password)){
            return "redirect: /html/Administrador"
        }else{
            return "redirect/html/Login"

        }

    
    }
    @GetMapping()
    public String irALogin(){
        return "redirect:/html/Login"
    }
}