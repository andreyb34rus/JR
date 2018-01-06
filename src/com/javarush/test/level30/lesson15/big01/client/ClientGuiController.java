package com.javarush.test.level30.lesson15.big01.client;


public class ClientGuiController extends Client {

    // ������ � ���������������� ����, ���������� �� ������ ClientGuiModel model.
    private ClientGuiModel model = new ClientGuiModel();

    // ������ � ���������������� ����, ���������� �� ������������� ClientGuiView view.
    // �������, ��� ����� �������� � ����������� ��� ������������� �������
    private ClientGuiView view = new ClientGuiView(this);


    /** PSVM **/
    public static void main(String[] args) {

        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }


    /** methods **/
    // ������ ��������� � ���������� ������ ���� GuiSocketThread.
    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    // ������ �������� ������ SocketThread ����� ����� getSocketThread()� �������� � ���� ����� run().
    // ���������, ������ ��� ������������� �������� ����� run � ��������� ������, ��� �� ��� ������ ��� ����������� �������.
    @Override
    public void run() {
        getSocketThread().run();
    }

    // ������ ����� ClientGuiModel getModel(), ������� ������ ���������� ������.
    public ClientGuiModel getModel() {
        return model;
    }

    //getters
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    /** inner class GuiSocketThread**/
    //������ ���������� ����� GuiSocketThread �������������� �� SocketThread. ����� GuiSocketThread ������ ���� ���������.
    public class GuiSocketThread extends SocketThread {


        // ������ ������������� ����� ��������� � ������ � �������� ���������� ������ ��������� � �������������.
        @Override
        protected void processIncomingMessage(String message) {

            model.setNewMessage(message);
            view.refreshMessages();
        }

        // ������ ��������� ������ ������������ � ������ � �������� ���������� ������ ������������� � �����������.
        @Override
        protected void informAboutAddingNewUser(String userName) {

            model.addUser(userName);
            view.refreshUsers();
        }

        // ������ ������� ������������ �� ������ � �������� ���������� ������ ������������� � �����������.
        @Override
        protected void informAboutDeletingNewUser(String userName) {

            model.deleteUser(userName);
            view.refreshUsers();
        }

        // ������ �������� ����������� ����� � �������������.
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

}
