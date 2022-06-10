public class NatGateway implements GateWay{
    private Subnet subnet;

    public NatGateway(Subnet subnet) {
        this.subnet = subnet;
    }
    @Override
    public boolean send(String msg) {
        return subnet.transfer(msg);
    }
}
