package engine.components;

import com.sun.javafx.geom.Vec2f;
import engine.core.event.Event;
import engine.core.event.types.KeyEvent;
import engine.core.event.types.KeyPressedEvent;
import engine.core.event.types.KeyReleasedEvent;

public class MoveComponent extends Component {

    private float m_Speed = 14.6f;

    boolean FORWARD = false,
            BACK = false,
            LEFT = false,
            RIGHT = false;

    @Override
    public void OnEvent(Event event) {
        if (event.GetType() == Event.Type.KEY_PRESSED) {
            KeyEvent((KeyPressedEvent) event);
        } else if (event.GetType() == Event.Type.KEY_RELEASED)
            KeyEvent((KeyReleasedEvent) event);

    }

    private void KeyEvent(KeyPressedEvent event) {
        if (event.GetKey() == KeyEvent.KEY_W) FORWARD = true;
        if (event.GetKey() == KeyEvent.KEY_S) BACK = true;
        if (event.GetKey() == KeyEvent.KEY_A) LEFT = true;
        if (event.GetKey() == KeyEvent.KEY_D) RIGHT = true;
    }

    private void KeyEvent(KeyReleasedEvent event) {
        if (event.GetKey() == KeyEvent.KEY_W) FORWARD = false;
        if (event.GetKey() == KeyEvent.KEY_S) BACK = false;
        if (event.GetKey() == KeyEvent.KEY_A) LEFT = false;
        if (event.GetKey() == KeyEvent.KEY_D) RIGHT = false;
    }

    @Override
    public void OnUpdate(float delta) {
        Vec2f velocity = new Vec2f(0, 0);


        if (FORWARD) velocity.y -= 1;
        if (BACK) velocity.y += 1;
        if (LEFT) velocity.x -= 1;
        if (RIGHT) velocity.x += 1;

        velocity.

        Move(xVel * m_Speed * delta, yVel * m_Speed * delta);
    }

    private void Move(float xAmt, float yAmt) {
        m_Parent.SetPosition(m_Parent.GetTransform().GetX() + xAmt, m_Parent.GetTransform().GetY() + yAmt);
    }


}