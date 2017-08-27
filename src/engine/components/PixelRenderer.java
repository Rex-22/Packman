package engine.components;

import engine.gfx.Sprite;

import java.awt.*;

public class PixelRenderer extends Component {

    private Sprite m_Texture;

    public PixelRenderer(Sprite texture){
        m_Texture = texture;
    }

    @Override
    public void Init() {
        m_Texture.SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void Update() {
        if (m_Parent.HasMoved()){
            m_Texture.SetTransform(m_Parent.GetTransform());
        }
    }

    @Override
    public void Render(Graphics g) {
        m_Texture.Render(g);
    }

    public Sprite GetTexture() {
        return m_Texture;
    }

}
