package com.osp.projects.androidchatsocketioio.ui.rooms;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 *
 */

public class ChatPresenterImpl implements ChatPresenter {

    private ChatView chatView;

    public ChatPresenterImpl(ChatView chatView){
        this.chatView = chatView;
    }
}
