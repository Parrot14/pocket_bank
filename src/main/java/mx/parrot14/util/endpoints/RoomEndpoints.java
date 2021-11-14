package mx.parrot14.util.endpoints;

import static io.javalin.apibuilder.ApiBuilder.before;
import static io.javalin.apibuilder.ApiBuilder.post;

import io.javalin.apibuilder.EndpointGroup;
import io.javalin.http.RedirectResponse;
import mx.parrot14.Main.URL.WEB;
import mx.parrot14.util.Bank;
import mx.parrot14.util.Forms;
import mx.parrot14.util.room.RoomManager;

public class RoomEndpoints implements EndpointGroup {
    private final RoomManager manager;

    public RoomEndpoints(RoomManager manager) {
        this.manager = manager;
    }

    @Override
    public void addEndpoints() {
        before(WEB.ROOM.CREATE_JOIN, bef -> {
            if (!Forms.ROOM_FORM.verifyForm(bef)){
                bef.redirect(WEB.INDEX);
                throw new RedirectResponse(400);
            }

            String name = bef.formParam("name");
            String room = bef.formParam("room");

            if (!room.trim().isEmpty() && !manager.canJoin(room, name)) {
                bef.redirect(WEB.INDEX);
                throw new RedirectResponse(409);
            }

        });
        post(WEB.ROOM.CREATE_JOIN, post -> {
            String name = post.formParam("name");
            String room = post.formParam("room");

            if (room.trim().isEmpty()) {
                // Create MODE
                Bank bank = new Bank(name);
                room = manager.addRoom(bank);
                // TODO render owner bank view
            } else {
                // Join MODE
                if (!manager.joinRoom(room, name)) {
                    post.redirect(WEB.INDEX);
                } else {
                    // TODO render user bank view
                }
            }
        });
    }

}
