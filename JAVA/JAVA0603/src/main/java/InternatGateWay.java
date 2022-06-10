public class InternatGateWay implements GateWay{
    @Override
    public boolean send(String msg) {
        System.out.println(msg);
        return true;
    }
}
