package temp;

/**
 * 空对象模式
 * 对于类里的某个方法，如果
 */
public class NullDemo implements Man {

    /**
     * 这里就是空对象的兜底处理，可以保证输入有问题时也得到处理
     * lambda表达式: private static Action DO_NOTHING = () -> { /* do nothing *\/ };
     */
    private static Action DO_NOTHING = new Action() {
        public void killTree() { /* do nothing */ }
    };


    /**
     * 这里就是实现Parser的findAction()方法，并对不合法的输入进入兜底处理，
     * 保证这个方法的返回值一定不会为空
     * @param userInput
     * @return
     */
    public Action findAction(String userInput) {
        if (false  /* we can't find any actions */) {
//            return null;
            return DO_NOTHING;
        }

        // do normal...and then return

        //⬇这句话不用管，只是为了防止IDE报错
        return null;
        //⬆
    }
}


/**
 * Parse有一个接口FindAction，这个接口会依据用户的输入，找到并执行对应的动作。
 * 假如用户输入不对，可能就找不到对应的动作（Action），
 * 因此findAction就会返回null，接下来action调用doSomething方法时,就会出现空指针。
 */
interface Action {
    void killTree();
}

interface Man {
    Action findAction(String userInput);
}

/**
 * 错误示范
 */
class NaiveDemo {
/*
    Man parser = ManFactory.getParser();
    if (parser == null) {
        // now what?
        // this would be an example of where null isn't (or shouldn't be) a valid response
    }
    Action action = parser.findAction(someInput);
    if (action == null) {
        // do nothing} else {
        action.killTree();
    }
*/
}
