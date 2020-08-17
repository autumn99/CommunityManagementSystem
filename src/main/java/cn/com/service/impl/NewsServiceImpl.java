package cn.com.service.impl;

import cn.com.mapper.NewsMapper;
import cn.com.entity.News;
import cn.com.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Boolean interInfo(News news) {
        return newsMapper.interInfo(news);
    }

    @Override
    public List<News> selAll() {
        return newsMapper.selAll();
    }

    @Override
    public Boolean deleteById(int newsId) {
        return newsMapper.deleteById(newsId);
    }
}
