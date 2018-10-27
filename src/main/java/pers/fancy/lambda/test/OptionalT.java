package pers.fancy.lambda.test;

import java.util.Optional;

/**
 * 作用描述：
 *
 * @auther: Administrator
 * @date: 2018/10/25 0025 22:07
 */
public class OptionalT {
    public static void main(String[] args) {

    }

    public static String getName(User u) {
        return Optional.ofNullable(u)
                .map(user->user.getUserName())
                .orElse("Unknown");
    }

//    public static String getChampionName(Competition comp) throws IllegalArgumentException {
//        return Optional.ofNullable(comp)
//                .map(c->c.getResult())
//                .map(r->r.getChampion())
//                .map(u->u.getName())
//                .orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available."));
//    }
//
//    public void setName(String name) throws IllegalArgumentException {
//        this.name = Optional.ofNullable(name).filter(User::isNameValid)
//                .orElseThrow(()->new IllegalArgumentException("Invalid username."));
//    }
}
