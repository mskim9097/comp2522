package ca.bcit.comp2522.apple

abstract class IDevice
{
    private final String purpose;

    public IDevice(final String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose()
    {
        return "Unknown Purpose";
    }

    abstract public void printDetails();
}
