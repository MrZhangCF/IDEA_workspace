package demo;

import com.blade.Blade;
import com.blade.mvc.annotation.*;

@Path
public class Test {
    public static void main(String[] args){
        Blade.of().get("/",ctx->ctx.text("hello world")).start();

    }

    @PostRoute("/save")
    public void savePerson(@Param String username, @Param Integer age){
        System.out.println("username is: " + username + "age is:" + age);
    }

    @GetRoute("/users/:username/:pw")
    public void save(@PathParam String username, @PathParam String pw){
        System.out.println("username is: " + username + "pw is:" + pw);
    }
}
